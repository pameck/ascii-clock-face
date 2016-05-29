(ns clock-formatter
  (:require
    [clojure.string :as str]))

(defn format-it
  [input]
  println (str "hh = " (first input) " mm = " (second input)))

(def empty-clock
  (ref (vector
    (vector " " " " " " "o" " " " " " ")
    (vector " " " " "o" " " "o" " " " ")
    (vector " " "o" " " " " " " "o" " ")
    (vector "o" " " " " " " " " " " "o")
    (vector " " "o" " " " " " " "o" " ")
    (vector " " " " "o" " " "o" " " " ")
    (vector " " " " " " "o" " " " " " ")
  ))
)

(defn to-analog-format
  [militar-time]
  militar-time)

(defn replace-element
  [vct position newValue]
  (assoc vct position newValue)
)

(defn set-time
  [matrix row column label]
  (replace-element matrix row (replace-element (nth matrix row) column label))
)

(defn point-hand
  [clock pointTo label]
  (case pointTo
      1   (set-time clock 1 4 label)
      2   (set-time clock 2 5 label)
      3   (set-time clock 3 6 label)
      4   (set-time clock 4 5 label)
      5   (set-time clock 5 4 label)
      6   (set-time clock 6 3 label)
      7   (set-time clock 5 2 label)
      8   (set-time clock 4 1 label)
      9   (set-time clock 3 0 label)
      10  (set-time clock 2 1 label)
      11  (set-time clock 1 2 label)
      12  (set-time clock 0 3 label)))

(defn set-hour
  [clock hour]
  (point-hand clock hour "h"))

(defn set-minutes
  [clock minutes]
  (point-hand clock minutes "m"))