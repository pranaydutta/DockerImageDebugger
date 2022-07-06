pipeline {
    agent any
	
	
	stages{
	
	stage ('Build') {
	
	 steps {
		 echo "inside Build stage"
		  sh 'mvn clean deploy'
                sh 'mvn install' 
            }
	
	}
	}
	
	}
