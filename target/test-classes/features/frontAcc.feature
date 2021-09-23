Feature:

Scenario Outline: To do data driven testing on Login Functionality
Given User is on Login Page 
When User enters username as "<userName>" & password as "<passWord>" & clicks on login
Then login "<loginType>" should happen

Examples:
|userName| passWord| loginType	|
|demouser| password| should			|
|admin	 | admin123| shouldNot	|
|hr			 | hr123	 | shouldNot	|
|demo		 |demo123	 | shouldNot	|