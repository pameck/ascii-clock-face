(ns core-test
  (:require [clojure.test :refer :all]
            [core :refer :all]))

(deftest parse-input-tests
  (testing "it should parse hh:mm to a vector with hours and minutes"
    (is (= [12 35] (core/parse-input "12:35"))))

  (testing "it should handle when the input is malformed"
    (is (= nil (core/parse-input "1235"))))

  (testing "it should handle when the values are not valid"
    (is (= nil (core/parse-input "52:35")))))

(deftest get-time-tests
  (testing "it should parse hh:mm to a map with hours and minutes"
    (is (= 12 (first (core/get-time "12:35"))))
    (is (= 35 (second (core/get-time "12:35"))))))

(deftest validate-input-format-tests
  (testing "it should return the value when format is ##:##"
    (is (= "12:35" (core/validate-input-format "12:35"))))

  (testing "it should return nil when format not ##:##"
    (is (= nil (core/validate-input-format "1:35")))
    (is (= nil (core/validate-input-format "12:5")))
    (is (= nil (core/validate-input-format "12445")))
    (is (= nil (core/validate-input-format "125")))
    (is (= nil (core/validate-input-format "AA:45")))
    (is (= nil (core/validate-input-format "12:425")))))

(deftest valid-minutes-tests
  (testing "it should return false when minutes negative"
    (is (= false (core/valid-minutes [11 -1]))))

  (testing "it should return false when minutes greater than 59"
    (is (= false (core/valid-minutes [11 60]))))

  (testing "it should return true when minutes between 0 and 59"
    (is (= true (core/valid-minutes [11 43])))
    (is (= true (core/valid-minutes [11 0])))
    (is (= true (core/valid-minutes [11 59])))))

(deftest valid-hours-tests
  (testing "it should return false when hours negative"
    (is (= false (core/valid-hours [-2 10]))))

  (testing "it should return false when hours greater than 23"
    (is (= false (core/valid-hours [24 20]))))

  (testing "it should return true when hours between 0 and 23"
    (is (= true (core/valid-hours [0 43])))
    (is (= true (core/valid-hours [2 20])))
    (is (= true (core/valid-hours [23 59])))))

(deftest validate-time-tests
  (testing "it should return nil if not valid"
    (is (= nil (core/validate-time [55 59])))))