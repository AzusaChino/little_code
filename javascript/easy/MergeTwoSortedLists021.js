function ListNode(val) {
  this.val = val
  this.next = null
}

const merge = (l1, l2) => {
  if (l1 === null) {
    return l2
  }
  if (l2 === null) {
    return l1
  }
  if (l1.val > l2.val) {
    l2.next = merge(l1, l2.next)
    return l2
  } else {
    l1.next = merge(l1.next, l2)
    return l1
  }
}

console.log(merge(new ListNode(1), new ListNode(3)))
