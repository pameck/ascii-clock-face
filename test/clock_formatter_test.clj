(ns clock-formatter-test
  (:require [clojure.test :refer :all]
            [clock-formatter :refer :all]))

(deftest format-it-tests
  (testing "it should format a clock with the correct hours"
    (is (= "hh = 5 mm = 30" (clock-formatter/format-it [5 30])))))


(deftest to-analog-format-tests
  (testing "it should transform hours to 12 hour format"
    (is (= [1 32]  (to-analog-format [1 32])))
    (is (= [2 32]  (to-analog-format [2 32])))
    (is (= [12 32] (to-analog-format [12 32])))
    ; (is (= [1 32]  (to-analog-format [13 32])))
    ; (is (= [2 32]  (to-analog-format [14 32])))
    ; (is (= [10 32] (to-analog-format [22 32])))
    ; (is (= [12 32] (to-analog-format [24 32])))
    ))