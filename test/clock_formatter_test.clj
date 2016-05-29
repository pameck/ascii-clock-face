(ns clock-formatter-test
  (:require [clojure.test :refer :all])
  (:use [clock-formatter :only [format-it empty-clock point-minutes-hand point-hours-hand to-analog-format]]))

(deftest format-it-tests
  (testing "it should return a clock-matrix representing a clockface with the time set"
    (is (= "hh = 5 mm = 30" (format-it [5 30])))))

(deftest to-analog-format-tests
  (testing "it should transform militar time to analog time"
    (is (= [0 0]  (to-analog-format 0 0)))
    (is (= [1 6]  (to-analog-format 1 32)))
    (is (= [2 5]  (to-analog-format 2 27)))
    (is (= [0 9]  (to-analog-format 12 45)))
    (is (= [1 11]  (to-analog-format 13 59)))
    (is (= [11 6] (to-analog-format 23 30))))
  )

(deftest point-hours-hand-tests
  (testing "it should return the clock-matrix with an h set to the corresponding hour position"
    (is (= [" " " " "h" " " "o" " " " "] (second (point-hours-hand @empty-clock 11))))
    (is (= [" " "h" " " " " " " "o" " "] (nth (point-hours-hand @empty-clock 8) 4)))))

(deftest point-minutes-hand-tests
  (testing "it should return the clock-matrix with an m set in the corresponding minute position"
    (is (= [" " " " " " "m" " " " " " "] (first (point-minutes-hand @empty-clock 12)))))

  (testing "it should return the clock-matrix with an x in the corresponding position when hours and minutes set to the same position"
    (is (= [" " " " " " "x" " " " " " "] (first (point-minutes-hand (point-hours-hand @empty-clock 12) 12))))))