package com.mst.generics.ex2;

//Example usage with a custom class implementing Reduceable
class Example implements Reduceable<Integer> {
 private Integer value;

 Example(Integer value) {
     this.value = value;
 }

 @Override
 public Integer reduce() {
     return value / 2; // Example reduction logic
 }

 @Override
 public String toString() {
     return value.toString();
 }
}