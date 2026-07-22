(ns marketentry.facts-test
  (:require [clojure.test :refer [deftest is testing]]
            [marketentry.facts :as facts]))

(deftest gbr-has-spec-basis
  (let [sb (facts/spec-basis "GBR")]
    (is (some? sb))
    (is (string? (:provenance sb)))
    (is (seq (:required-evidence sb)))
    (is (some? (facts/rep-spec-basis "GBR")))
    (is (some? (facts/corporate-number-spec-basis "GBR")))))

(deftest unknown-jurisdiction-has-no-spec-basis
  (is (nil? (facts/spec-basis "ATL")))
  (is (nil? (facts/spec-basis "ZZZ"))))

(deftest required-evidence-satisfied
  (let [sb (facts/spec-basis "GBR")
        all (:required-evidence sb)]
    (is (true? (facts/required-evidence-satisfied? "GBR" all)))
    (is (not (facts/required-evidence-satisfied? "GBR" (take 1 all))))
    (is (nil? (facts/required-evidence-satisfied? "ATL" all)))))

(deftest coverage-is-honest
  (let [c (facts/coverage ["GBR" "ATL" "ZZZ"])]
    (is (= 3 (:requested c)))
    (is (= 1 (:covered c)))
    (is (= ["ATL" "ZZZ"] (:missing-jurisdictions c)))))
