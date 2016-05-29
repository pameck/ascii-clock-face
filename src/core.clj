(ns core
  (:require
    [clojure.string :as str])
  (:use
    [input :only [parse-input]]
    [clock-formatter :only [format-it]]))

(def wrong-input (ref "Try typing something in this format instead hh:mm"))

(defn clock-face
  [user-input]
  (if-let [the-time (parse-input user-input)]
    (format-it the-time)
    @wrong-input))

(defn -main
  [& args]
  (if (= 1 (count args))
    (doseq [line (clock-face (first args))]
      (println (str/join " " line)))
    (println (str "Too many arguments, " @wrong-input))))
