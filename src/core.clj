(ns core
  (:use
    [input :only [parse-input]]
    [clock-formatter :only [format-it]]))

(defn do-magic
  [user-input]
  (if-let [the-time (parse-input user-input)]
    (format-it the-time)
    "Oops! Wrong Input! Try typing something in this format instead hh:mm"))

(defn -main
  [& args]
  (println (do-magic (first args))))
