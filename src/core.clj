(ns core
  (:require
    [clojure.string :as str]))

(defn parse-time [input]
  (map (fn [value]
         (Integer. value)) (str/split input #":")))

(defn -main
  [& args]
  (println (parse-time (first args))))
