BattleShip Instructions

TO RUN THE SERVER ON THE HOST MACHINE:
1. Ensure the XAMPP MySQL instance is running with the same login credentials and user space implemented during class labs (username=student, password=hello, workspace=student_space).
2. (ONLY ONCE) Within the system terminal, navigate and login to the mysql instance as was done during class labs (cd to xampp/mysql/bin, execute 'mysql -h localhost -u student -p' and 'use student_space'), then execute the provided 'define.sql' script. (in the mysql cli, 'source PATH\TO\define.sql')
3. Run BattleShipServer.bat

TO RUN A CLIENT ON A SEPARATE MACHINE
1. Edit BattleShipClient.bat, replacing 127.0.0.1 (local host) to the local IP address of the server machine
2. Run BattleShipClient.bat
