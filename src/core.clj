(ns core
  (:require
    [clojure.string :as str]))

(defn input-format-valid [input]
  (not (nil? (re-matches #"\d{2}:\d{2}" input))))

(defn parse-time [input]
  (map (fn [value]
         (Integer. value)) (str/split input #":")))

(defn -main
  [& args]
  (println (parse-time (first args))))
