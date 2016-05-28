(ns core
  (:require
    [clojure.string :as str]))

(defn valid-input-format
  "Returns true if format is ##:##"
  [input]
  (not (nil? (re-matches #"\d{2}:\d{2}" input))))

(defn get-time
  "Takes a string with format ##:## and returns a records with hours and minutes"
  [input]
  (map (fn [value]
         (Integer. value)) (str/split input #":")))

(defn parse-input
  "Takes user input and parses it into hours and minutes"
  [input]
  (if (not (valid-input-format input))
    {:input nil :error "Wrong input! It should be hh:mm"}
    {:input (get-time input) :error nil}))

(defn -main
  [& args]
  (println (parse-input (first args))))
