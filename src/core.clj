(ns core
  (:require
    [clojure.string :as str]))

(defn valid-input-format
  "Returns true if format is ##:##"
  [input]
  (not (nil? (re-matches #"\d{2}:\d{2}" input))))

(defn parse-time
  "Takes a string with format ##:## and returns a records with hours and minutes"
  [input]
  (if (not (valid-input-format input))
    {:input nil :error "Wrong input! It should be hh:mm"}
    {:input (map (fn [value]
         (Integer. value)) (str/split input #":")) :error nil}))

(defn -main
  [& args]
  (println (parse-time (first args))))
