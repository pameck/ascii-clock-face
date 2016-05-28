(ns display-test
  (:require [clojure.test :refer :all]
            [display :refer :all]))

(deftest show-tests
  (testing "it should display a clock with the correct hours"
    (is (= "hh = 5 mm = 30" (display/show [5 30]) )
    )
  )
)

(deftest getLines-tests
  (testing "it should get an array with 7 empty lines"
    (is (= ["   0" "  0 0" " 0   0" "0     0" " 0   0" "  0 0" "   0"] (display/getLines [0 0]) )
    )
  )

  ; (testing "it should get an array with the correct ours"
  ;   (is (= ["   0   " "  0 0  " " 0   0" "0     0" " 0   0" "  h 0" "   0"] (display/getLines [7 0]) )
  ;   )
  ; )
)


(deftest spacer-tests
  (testing "it should display the number of spaces correctly"
    (is (= "   " (display/spacer 3) )
    )
    (is (= "" (display/spacer 0) )
    )
  )
)

(deftest formatSngl-tests
  (testing "it should display the number with the correct format"
    (is (= "   0" (display/formatSngl 3) )
    )
  )
)