package util;

/**
 * @author Lin
 * @date 2023/7/3
 */
public class ListNode extends Node{
  public ListNode next;
  public int val;

  public ListNode() {
  }

  public ListNode(int value) {
    this.val = value;
  }

  @Override
  public String toString() {
    return "Node{value=" + val + '}';
  }
}
