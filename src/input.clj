(ns input
  (:require
    [clojure.string :as str]))

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
  "Takes a string with format ##:## and returns a record with hours and minutes"
  [input]
  (validate-time (map #(Integer/parseInt %) (str/split input #":"))))

(defn parse-input
  "Takes the user input and parses it into hours and minutes"
  [input]
  (when-let [well-formatted-input (validate-input-format input)]
    (get-time well-formatted-input)))