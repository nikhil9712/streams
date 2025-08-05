package streams.model;

import java.util.Objects;

public class Student {

	int rollNo;
	String name;
	String address;

	public Student(int rollNo, String name, String address) {
		this.rollNo = rollNo;
		this.name = name;
		this.address = address;
	}

	public int getRollNo() {
		return rollNo;
	}

	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Student [rollNo=" + rollNo + ", name=" + name + ", address=" + address + "]";
	}

	@Override
	public boolean equals(Object obj2) {
		if (this == obj2) {
			return true;
		}
		if (obj2 instanceof Student) {
			Student s = (Student) obj2;
			if (this.name.equals(s.name) && this.rollNo==s.rollNo && this.address.equals(s.address)) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public int hashCode(){
		return rollNo+Objects.hash(name)+Objects.hash(address);
	}

}
