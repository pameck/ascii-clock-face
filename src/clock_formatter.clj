(ns clock-formatter
  (:require
    [clojure.string :as str]))

(defn spacer
  [times]
  (apply str (repeat times " ")))

(defn formatDbl
  [init final]
  (str (spacer init) 0 (spacer (- final init 1)) 0))

(defn formatSngl
  [init]
  (str (spacer init) 0))

(defn format-it
  [input]
  println (str "hh = " (first input) " mm = " (second input)))

(defn getLines
  [input]
  [(formatSngl 3) (formatDbl 2 4) " 0   0" "0     0" " 0   0" "  0 0" "   0"])

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
)

(defn replaceInMatrix
  [matrix row column label]
  (replaceInVector matrix row (replaceInVector (nth matrix row) column label)) 
)

(defn replaceInVector 
  [vct position newValue]
  (assoc vct position newValue)
)