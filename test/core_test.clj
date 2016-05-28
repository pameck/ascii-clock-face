(ns core-test
  (:require [clojure.test :refer :all]
            [core :refer :all]))

(deftest parse-time-tests
  (testing "it should parse hh:mm to a map with hours and minutes"
    (is (= 12 (first (core/parse-time "12:35"))))
    (is (= 35 (second (core/parse-time "12:35")))))

  (testing "it should handle when the input is malformed"
    (is (= 1 1)))

  (testing "it should handle when the values are not valid"
    (is (= 1 1))))

(deftest validate-input-format-tests
  (testing "it should return true when format is ##:##"
    (is (= {:input "12:35", :error nil} (core/validate-input-format "12:35"))))

  (testing "it should return false when format not ##:##"
    (is (= {:input nil, :error "Wrong input! It should be hh:mm"} (core/validate-input-format "1:35")))
    (is (= {:input nil, :error "Wrong input! It should be hh:mm"} (core/validate-input-format "12:5")))
    (is (= {:input nil, :error "Wrong input! It should be hh:mm"} (core/validate-input-format "12445")))
    (is (= {:input nil, :error "Wrong input! It should be hh:mm"} (core/validate-input-format "125")))
    (is (= {:input nil, :error "Wrong input! It should be hh:mm"} (core/validate-input-format "AA:45")))
    (is (= {:input nil, :error "Wrong input! It should be hh:mm"} (core/validate-input-format "12:425")))))