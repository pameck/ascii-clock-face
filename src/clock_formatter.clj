(ns clock-formatter
  (:require
    [clojure.string :as str]))

(defn format-it
  [input]
  println (str "hh = " (first input) " mm = " (second input)))

(def emptyClock
  (ref (vector
    (vector "_" "_" "_" "0" "_" "_" "_")
    (vector "_" "_" "0" "_" "0" "_" "_")
    (vector "_" "0" "_" "_" "_" "0" "_")
    (vector "0" "_" "_" "_" "_" "_" "0")
    (vector "_" "0" "_" "_" "_" "0" "_")
    (vector "_" "_" "0" "_" "0" "_" "_")
    (vector "_" "_" "_" "0" "_" "_" "_")
  ))
)

(defn setLabel
  [clock value label]
  (case value
      1 (replaceInMatrix clock 1 4 "h")
  )
(defn to-analog-format
  [militar-time]
  militar-time)
)

(defn replaceInMatrix
  [matrix row column label]
  (replaceInVector matrix row (replaceInVector (nth matrix row) column label)) 
)

(defn replaceInVector 
  [vct position newValue]
  (assoc vct position newValue)
)