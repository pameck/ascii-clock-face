(ns display
  (:require
    [clojure.string :as str]))

(defn spacer
  [times]
  (apply str (repeat times " "))
)

(defn formatDbl
  [init final]
  (str (spacer init) 0 (spacer (- final init 1)) 0 
  )  
)

(defn formatSngl
  [init]
  (str (spacer init) 0
  )  
)

(defn show
  [input]
  println (str "hh = " (first input) " mm = " (second input))
)

(defn getLines
  [input]
  [(formatSngl 3) (formatDbl 2 4) " 0   0" "0     0" " 0   0" "  0 0" "   0"]
)