package com.viraj;
public class Lab_11_Student_Structure
{
    static class Student {
            int id;
            String name;
            com.viraj.Student_Structure.Student next;

            public Student(int id, String name) {
                this.id = id;
                this.name = name;
                this.next = null;
            }
        }

        static class StudentLinkedList {
            private com.viraj.Student_Structure.Student head;

            public StudentLinkedList() {
                this.head = null;
            }

            public void insert(com.viraj.Student_Structure.Student student) {
                if (head == null) {
                    head = student;
                } else {
                    com.viraj.Student_Structure.Student temp = head;
                    while (temp.next != null) {
                        temp = temp.next;
                    }
                    temp.next = student;
                }
            }

            public void traverse() {
                com.viraj.Student_Structure.Student temp = head;
                while (temp != null) {
                    System.out.println("ID: " + temp.id + ", Name: " + temp.name);
                    temp = temp.next;
                }
            }

            public void delete(int id) {
                if (head == null) {
                    return;
                }
                if (head.id == id) {
                    head = head.next;
                    return;
                }
                com.viraj.Student_Structure.Student temp = head;
                while (temp.next != null && temp.next.id != id) {
                    temp = temp.next;
                }
                if (temp.next != null) {
                    temp.next = temp.next.next;
                }
            }

            public com.viraj.Student_Structure.Student concatenate(com.viraj.Student_Structure.Student head2) {
                if (head == null) {
                    return head2;
                }
                com.viraj.Student_Structure.Student temp = head;
                while (temp.next != null) {
                    temp = temp.next;
                }
                temp.next = head2;
                return head;
            }

            public void insertSorted(com.viraj.Student_Structure.Student element) {
                if (head == null || element.id < head.id) {
                    element.next = head;
                    head = element;
                    return;
                }
                com.viraj.Student_Structure.Student temp = head;
                while (temp.next != null && element.id > temp.next.id) {
                    temp = temp.next;
                }
                element.next = temp.next;
                temp.next = element;
            }

            public void insertQueue(com.viraj.Student_Structure.Student element) {
                if (head == null) {
                    head = element;
                } else {
                    com.viraj.Student_Structure.Student temp = head;
                    while (temp.next != null) {
                        temp = temp.next;
                    }
                    temp.next = element;
                }
            }

            public com.viraj.Student_Structure.Student deleteQueue() {
                if (head == null) {
                    return null;
                }
                com.viraj.Student_Structure.Student deletedNode = head;
                head = head.next;
                deletedNode.next = null;
                return deletedNode;
            }
        }

        public static void main(String[] args) {
            com.viraj.Student_Structure.StudentLinkedList list = new com.viraj.Student_Structure.StudentLinkedList();

            // Test inserting students
            list.insert(new com.viraj.Student_Structure.Student(1, "Viraj"));
            list.insert(new com.viraj.Student_Structure.Student(2, "Yash"));
            list.insert(new com.viraj.Student_Structure.Student(3, "Ganesh"));

            // Test traversing the list
            System.out.println("Students in the list:");
            list.traverse();

            // Test deleting a student
            list.delete(2);
            System.out.println("After deleting student with ID 2:");
            list.traverse();

            // Test concatenating two lists
            com.viraj.Student_Structure.StudentLinkedList list2 = new com.viraj.Student_Structure.StudentLinkedList();
            list2.insert(new com.viraj.Student_Structure.Student(4, "Arpit"));
            list2.insert(new com.viraj.Student_Structure.Student(5, "Ashutosh"));

            System.out.println("Students in the second list:");
            list2.traverse();

            list.concatenate(list2.head);
            System.out.println("Concatenated list:");
            list.traverse();

            // Test inserting an element in sorted order
            com.viraj.Student_Structure.Student newStudent = new com.viraj.Student_Structure.Student(6, "Ajay");
            list.insertSorted(newStudent);
            System.out.println("After inserting new student in sorted order:");
            list.traverse();

            // Test insertQueue and deleteQueue
            com.viraj.Student_Structure.StudentLinkedList queueList = new com.viraj.Student_Structure.StudentLinkedList();
            queueList.insertQueue(new com.viraj.Student_Structure.Student(10, "Niyati"));
            queueList.insertQueue(new com.viraj.Student_Structure.Student(11, "Nirali"));

            System.out.println("Students in the queue list:");
            queueList.traverse();

            com.viraj.Student_Structure.Student deletedNode = queueList.deleteQueue();
            System.out.println("Deleted node from the queue: ID: " + deletedNode.id + ", Name: " + deletedNode.name);
            System.out.println("Updated queue list:");
            queueList.traverse();
        }
    }
