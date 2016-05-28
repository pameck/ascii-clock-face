(ns core
  (:require
    [clojure.string :as str]))

(defn validate-input-format [input]
  false)

(defn parse-time [input]
  (map (fn [value]
         (Integer. value)) (str/split input #":")))

(defn -main
  [& args]
  (println (parse-time (first args))))
