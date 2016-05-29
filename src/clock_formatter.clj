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

(defn to-analog-hours
  [militar-hour]
  (if (< militar-hour 12)
    militar-hour
    (- militar-hour 12)
  )
)

(defn to-analog-minutes
  [militar-minutes]
  (int (Math/floor (/ militar-minutes 5)))
)

(defn to-analog-format
   [militar-hour militar-minutes]
   [(to-analog-hours militar-hour) (to-analog-minutes militar-minutes)]
)

(defn matrix-get
  [vector-2d row column]
  (nth (nth vector-2d row) column))

(defn move-hand
  [clock row column unit]
  (assoc clock row
      (if (not= "o" (matrix-get clock row column))
          (assoc (nth clock row) column "x")
          (assoc (nth clock row) column unit))))

(defn point-hand
  [clock pointTo unit]
  (case pointTo
      1   (move-hand clock 1 4 unit)
      2   (move-hand clock 2 5 unit)
      3   (move-hand clock 3 6 unit)
      4   (move-hand clock 4 5 unit)
      5   (move-hand clock 5 4 unit)
      6   (move-hand clock 6 3 unit)
      7   (move-hand clock 5 2 unit)
      8   (move-hand clock 4 1 unit)
      9   (move-hand clock 3 0 unit)
      10  (move-hand clock 2 1 unit)
      11  (move-hand clock 1 2 unit)
      12  (move-hand clock 0 3 unit)))

(defn point-hours-hand
  [clock hour]
  (point-hand clock hour "h"))

(defn point-minutes-hand
  [clock minutes]
  (point-hand clock minutes "m"))