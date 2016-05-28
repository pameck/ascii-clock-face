(ns clock-formatter-test
  (:require [clojure.test :refer :all]
            [clock-formatter :refer :all]))

(deftest format-it-tests
  (testing "it should format a clock with the correct hours"
    (is (= "hh = 5 mm = 30" (clock-formatter/format-it [5 30])))))

(deftest getLines-tests
  (testing "it should get an array with 7 empty lines"
    (is (= ["   0" "  0 0" " 0   0" "0     0" " 0   0" "  0 0" "   0"] (clock-formatter/getLines [0 0])))))


(deftest spacer-tests
  (testing "it should format the number of spaces correctly"
    (is (= "   " (clock-formatter/spacer 3)))
    (is (= "" (clock-formatter/spacer 0)))))

(deftest formatSngl-tests
  (testing "it should format the number with the correct format"
    (is (= "   0" (clock-formatter/formatSngl 3)))))