(ns display-test
  (:require [clojure.test :refer :all]
            [display :refer :all]))

(deftest display-tests
  (testing "it should display a clock with the correct hours"
    (is (= "hh = 5 mm = 30" (display/show [5 30]) )
    )
  )
)
