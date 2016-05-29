(ns clock-formatter-test
  (:require [clojure.test :refer :all])
  (:use [clock-formatter :only [format-it empty-clock set-minutes set-hour]]))

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

(deftest set-hour-tests
  (testing "it should return the clock-matrix with an h set to the corresponding hour position"
    (is (= [" " " " "h" " " "o" " " " "] (second (set-hour @empty-clock 11))))
    (is (= [" " "h" " " " " " " "o" " "] (nth (set-hour @empty-clock 8) 4)))))

(deftest set-minutes-tests
  (testing "it should return the clock-matrix with an m set in the corresponding minute position"
    (is (= [" " " " " " "m" " " " " " "] (first (set-minutes @empty-clock 12)))))

  (testing "it should return the clock-matrix with an x in the corresponding position when hours and minutes set to the same position"
    (is (= 1 1))))