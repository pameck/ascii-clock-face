(ns display
  (:require
    [clojure.string :as str]))

(defn show
  [input]
  println (str "hh = " (first input) " mm = " (second input))
)