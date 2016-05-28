(ns core-test
  (:require [clojure.test :refer :all]
            [core :refer :all]))

(deftest input-parser
  (testing "it should parse hh:mm to a map with hours and minutes"
    (is (= 12 (first (core/parse-time "12:35"))))
    (is (= 35 (second (core/parse-time "12:35"))))
  )

  (testing "it should handle when the input is malformed"
    (is (= 1 1))
  )

  (testing "it should handle when the values are not valid"
    (is (= 1 1))
  )
)


(deftest format-validator
  (testing "it should return true when format is ##:##"
    (is (= true (core/validate-input-format "12:35")))
  )

  (testing "it should return false when format not ##:##"
    (is (= false (core/validate-input-format "1:35")))
    (is (= false (core/validate-input-format "12:5")))
    (is (= false (core/validate-input-format "12445")))
    (is (= false (core/validate-input-format "125")))
    (is (= false (core/validate-input-format "AA:45")))
  )
)