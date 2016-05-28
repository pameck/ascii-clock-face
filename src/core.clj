(ns core
  (:require
    [clojure.string :as str]))

(defn validate-input-format
  "Validates input format is ##:##"
  [input]
  (if (nil? (re-matches #"\d{2}:\d{2}" input))
    {:input nil, :error "Wrong input! It should be hh:mm"}
    {:input input, :error nil}))

(defn parse-time
  "Takes a string with format ##:## and returns a records with hours and minutes"
  [input]
  (if (not (nil? (:error (validate-input-format input))))
    (:error (validate-input-format input))
    (map (fn [value]
         (Integer. value)) (str/split input #":"))))

(defn -main
  [& args]
  (println (parse-time (first args))))
