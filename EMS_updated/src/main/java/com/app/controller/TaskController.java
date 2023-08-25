package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entities.Task;
import com.app.models.Response;
import com.app.service.TaskService;

@CrossOrigin
@RestController
@RequestMapping("/tasks")
public class TaskController {
//	@Autowired
//	private TaskService taskService;
//	
//	//admin can create new tasks for employees
//		//using post method of http, 
//		@PostMapping("/admin/addtask")
//		//get data from request body
//		public ResponseEntity<?>  addTask (@RequestBody Task task) {
//			try {
//				System.out.println("task ==>"+task);
//				//call service layer method
//				taskService.save(task);
//				return Response.success(null);
//			} catch (Exception e) {
//				e.printStackTrace();
//				return Response.error(null);
//			}
//		}
//		
//		//admin can see the list of all tasks
//		@GetMapping("/admin/gettask")
//		public ResponseEntity<?>  getTask () {
//			//a list of task is created which stores all the tasks returned
//			List<Task> list = taskService.findAll();
//			if (list != null) {
//				//prints on console
//				System.out.println("inside  =>" +list.toString());
//				return Response.success(list);
//			}
//			return Response.error(list);
//		}
//		
//
//		//admin can get the task of project by projectId
//		//what are the tasks related to project by using project id we can distinguish 
//		@GetMapping("/admin/gettaskofProject/{pId}")
//		//pid which comes from url is of type string
//		public ResponseEntity<?>  getTaskOfProject (@PathVariable String pId) {
//			System.out.println("in gettaskProj+++"+pId);
//			//pid is conveted into integer
//			List<Task> list = taskService.findByProject(Integer.parseInt(pId));
//			if (list != null) {
//				//print on console
//				System.out.println("inside T by Proj  =>" +list.toString());
//				return Response.success(list);
//			}
//			return Response.error(list);
//	}
//		
//		
//		
//		//updation of task by admin after submission from employee ,like report submit date , status 
//		@PutMapping("/admin/submittask")
//		public ResponseEntity<?>  getSubmit (@RequestBody Task task) {
//			try {
//				System.out.println("task ==>"+task);
//				//calling service layer method
//				taskService.update(task);
//				return Response.success(null);
//			} catch (Exception e) {
//				e.printStackTrace();
//				return Response.error(null);
//			}
//		}
//		
//		//this method is created for getting all those tasks whose approval status is waiting for individual employees that is why is required empid
//		@RequestMapping("/user/acceptlist/{empIdString}")
//		public ResponseEntity<?>  acceptList (@PathVariable String empIdString ) {
//			System.out.println("email get "+empIdString);
//			//converts string to integer
//			int empId = Integer.parseInt(empIdString);
//			//providing empid and approval status as waiting in the method parameter
//			List<Task> list = taskService.findByEmpAndApprovalStatus(empId, "waiting") ;
//			if (list != null) {
//				//prints on console
//				System.out.println("inside Accept List----  =>" +list.toString());
//				return Response.success(list);
//			}
//			return Response.error(null);
//		}
//		
//		//this method is created for editing or updating approvalstatus, tstatus, accept date
//		@PostMapping("/user/taskstatus")
//		public ResponseEntity<?>  updateStatus (@RequestBody Task task) {
//			try {
//				System.out.println("in accept------>>>>>"+task.toString());
//				//calling service layer method
//				taskService.updateStatus(task);
//				return Response.success(null);
//			} catch (Exception e) {
//				e.printStackTrace();
//				return Response.error(null);
//			}
//		}
//		
//		//this method is created for getting the  task for individual employees whose approval status is "accepted" 
//		@RequestMapping("/user/gettask/{empId}")
//		//@PathVariable is used for getting the value from url
//		public ResponseEntity<?>  getTask (@PathVariable String empId ) {
//			//calling service layer method
//			//list of task is created and it stores all the task having approvalstatus accepted
//			List<Task> list = taskService.findByEmpAndApprovalStatus(Integer.parseInt(empId), "accepted") ;
//			if (list != null) {
//				//print on the console
//				System.out.println("inside  =>" +list.toString());
//				return Response.success(list);
//			}
//			return Response.error(null);
//		}
//		
//		//this method is created for getting the  task for employees whose approval status is "rejected" 
//
//		@GetMapping("/admin/getrejecttask")
//		//@PathVariable is used for getting the value from url
//		public ResponseEntity<?>  getRejectTask () {
//			//calling service layer method
//			//list of task is created and it stores all the task having approvalstatus rejected
//			List<Task> list = taskService.findByApprovalStatus("rejected") ;
//			if (list != null) {
//				System.out.println("inside  =>" +list.toString());
//				return Response.success(list);
//			}
//			return Response.error(null);
//		}
//		
//		//this method is created for deleteing the task 
//		
//		
//		//admin can edit the task and make the changes
//		@PutMapping("/admin/edittask")
//		public ResponseEntity<?>  editTask (@RequestBody Task task) {
//			try {
//				System.out.println("task ==>"+task);
//				//calling service layer method
//				taskService.editTask(task);
//				return Response.success(null);
//			} catch (Exception e) {
//				e.printStackTrace();
//				return Response.error(null);
//			}
//		}
//		
//		//this method is created for getting the  task for individual employees whose approval status is "waiting" 
//		@GetMapping("/admin/waitingtasklist")
//		public ResponseEntity<?>  waitingList () {
//			//list of task is created and it stores all the task having approvalstatus waiting
//			List<Task> list = taskService.findByApprovalStatus("waiting") ;
//			if (list != null) {
//				//printing on the console
//				System.out.println("inside waiting List----  =>" +list.toString());
//				return Response.success(list);
//			}
//			return Response.error(null);
//		}
//		@GetMapping("/admin/accepttasklist")
//		public ResponseEntity<?>  acceptList () {
//			//list of task is created and it stores all the task having approvalstatus accepted
//			List<Task> list = taskService.findByApprovalStatus("accepted") ;
//			if (list != null) {
//				//printing on the console
//
//				System.out.println("inside Accept "
//						+ "List----  =>" +list.toString());
//				return Response.success(list);
//			}
//			return Response.error(null);
//		}
//	@DeleteMapping("/admin/taskdelete/{taskId}")
//	public ResponseEntity<?>  deleteTask (@PathVariable String taskId) {
//		//calling service layer method
//			
//		return ResponseEntity.status(HttpStatus.OK).body(taskService.delete(Long.parseLong(taskId)));
//		
//	}
}
