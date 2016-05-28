(ns core
  (:require
    [clojure.string :as str]
    [display :refer (show)]))

(defn valid-input-format
  "Returns true if format is ##:##"
  [input]
  (not (nil? (re-matches #"\d{2}:\d{2}" input))))

(defn valid-minutes
  [input-time]
  (and (<= (second input-time) 59)
        (>= (second input-time) 0)))

(defn valid-hours
  [input-time]
  (and (<= (first input-time) 23)
        (>= (first input-time) 0)))

(defn valid-time
  [input-time]
  (and (valid-hours input-time)
       (valid-minutes input-time)))

(defn get-time
  "Takes a string with format ##:## and returns a records with hours and minutes"
  [input]
  (map (fn [value]
         (Integer. value)) (str/split input #":")))

(defn parse-input
  "Takes user input and parses it into hours and minutes"
  [input]
  (if (not (valid-input-format input))
    {:time nil :error "Wrong input! It should be hh:mm"}
    {:time (get-time input) :error nil}))

(defn -main
  [& args]
  (println (show
              (:time (parse-input (first args)))
            )
  )
)
