(ns clock-formatter-test
  (:require [clojure.test :refer :all]
            [clock-formatter :refer :all]))

(deftest format-it-tests
  (testing "it should format a clock with the correct hours"
    (is (= "hh = 5 mm = 30" (clock-formatter/format-it [5 30])))))


