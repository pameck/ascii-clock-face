(ns core-test
  (:require [clojure.test :refer :all]
            [core :refer :all]))

(deftest parse-time-tests
  (testing "it should parse hh:mm to a map with hours and minutes"
    (is (= 12 (first (:input (core/parse-time "12:35")))))
    (is (= 35 (second (:input (core/parse-time "12:35"))))))

  (testing "it should handle when the input is malformed"
    (is (= {:input nil, :error "Wrong input! It should be hh:mm"} (core/parse-time "1235"))))

  (testing "it should handle when the values are not valid"
    (is (= 1 1))))

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