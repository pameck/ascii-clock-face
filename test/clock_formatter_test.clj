(ns clock-formatter-test
  (:require [clojure.test :refer :all])
  (:use [clock-formatter :only [format-it empty-clock point-hand]]))

(deftest format-it-tests
  (testing "it should return a clock-matrix representing a clockface with the time set"
    (is (= "hh = 5 mm = 30" (format-it [5 30])))))

(deftest to-analog-format-tests
  (testing "it should transform hours to 1 to 12 format"
    (is (= 1 1)))

  (testing "it should round down the minutes past the hour to the nearest 5"
    (is (= 1 1))

  (testing "it should transform minutes to 1 to 12 format"
    (is (= 1 1)))))

(deftest point-hand-tests
  (testing "it should return the clock-matrix with an h set to the corresponding hour position"
    (is (= [" " " " "h" " " "o" " " " "] (second (point-hand @empty-clock 11 "h"))))
    (is (= [" " "h" " " " " " " "o" " "] (nth (point-hand @empty-clock 8 "h") 4))))

  (testing "it should return the clock-matrix with an m set in the corresponding minute position"
    (is (= 1 1)))

  (testing "it should return the clock-matrix with an x in the corresponding position when hours and minutes set to the same position"
    (is (= 1 1))))