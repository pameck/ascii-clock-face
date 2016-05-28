(ns core-test
  (:require [clojure.test :refer :all]
            [core :refer :all]))

(deftest parse-input-tests
  (testing "it should parse hh:mm to a vector with hours and minutes"
    (is (= {:input [12 35], :error nil} (core/parse-input "12:35"))))

  (testing "it should handle when the input is malformed"
    (is (= {:input nil, :error "Wrong input! It should be hh:mm"} (core/parse-input "1235"))))

  (testing "it should handle when the values are not valid"
    (is (= 1 1))))

(deftest get-time-tests
  (testing "it should parse hh:mm to a map with hours and minutes"
    (is (= 12 (first (core/get-time "12:35"))))
    (is (= 35 (second (core/get-time "12:35"))))))

(deftest valid-input-format-tests
  (testing "it should return true when format is ##:##"
    (is (= true (core/valid-input-format "12:35"))))

  (testing "it should return false when format not ##:##"
    (is (= false (core/valid-input-format "1:35")))
    (is (= false (core/valid-input-format "12:5")))
    (is (= false (core/valid-input-format "12445")))
    (is (= false (core/valid-input-format "125")))
    (is (= false (core/valid-input-format "AA:45")))
    (is (= false (core/valid-input-format "12:425")))))

(deftest valid-minutes-tests
  (testing "it should return false when minutes negative"
    (is (= false (core/valid-minutes [11 -1]))))

  (testing "it should return false when minutes greater than 59"
    (is (= false (core/valid-minutes [11 60]))))

  (testing "it should return true when minutes between 0 and 59"
    (is (= true (core/valid-minutes [11 43])))
    (is (= true (core/valid-minutes [11 0])))
    (is (= true (core/valid-minutes [11 59])))))