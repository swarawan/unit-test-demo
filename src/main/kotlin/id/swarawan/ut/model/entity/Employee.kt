package id.swarawan.ut.model.entity

import org.hibernate.annotations.DynamicInsert
import org.hibernate.annotations.DynamicUpdate
import javax.persistence.*

@Entity
@Table(name = "employee_data")
@DynamicInsert
@DynamicUpdate
data class Employee(

	@Id
	@Column(name = "ed_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	val id: Long,

	@Column(name = "ed_name")
	val name: String,

	@Column(name = "ed_email")
	val email: String
)