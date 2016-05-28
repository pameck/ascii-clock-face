(ns core
  (:require
    [clojure.string :as str]
    [clock-formatter :refer (format-it)]))

(defn validate-input-format
  "Returns true if format is ##:##"
  [input]
  (re-matches #"\d{2}:\d{2}" input))

(defn valid-minutes
  [input-time]
  (and (<= (second input-time) 59)
        (>= (second input-time) 0)))

(defn valid-hours
  [input-time]
  (and (<= (first input-time) 23)
        (>= (first input-time) 0)))

(defn validate-time
  [input-time]
  (if (and (valid-hours input-time)
       (valid-minutes input-time))
    input-time))

(defn get-time
  "Takes a string with format ##:## and returns a records with hours and minutes"
  [input]
  (let [[hours minutes] (str/split input #":")]
     (validate-time (vector (Integer. hours) (Integer. minutes)))))

(defn parse-input
  "Takes the user input and parses it into hours and minutes"
  [input]
  (when-let [well-formatted-input (validate-input-format input)]
    (get-time well-formatted-input)))

(defn do-magic
  [input]
  (let [{error :error, the-time :time} (parse-input input)]
    (if (some? error)
      error
      (if (validate-time the-time)
        (clock-formatter/format-it the-time)
        "Not valid"))))

(defn -main
  [& args]
  (println (parse-input (first args))))
