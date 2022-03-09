# Team6Workspace

# Current status of Design Document Progress:
* 1: Class Diagram PNG with methods and variables 
* - Diagram is finished but needs to be touched up to be readable
* - Methods and variables need to be done
* 2: Zipped Papyrus Project of Class Diagram
* - Nothing needs to be done here
* 3: Package Diagram PNG
* - Diagram is finished
* 4: Input/Output list for each package
* - Is below but probably needs to be refined
* 5: Classes sorted into Packages Diagram PNGs
* - Diagrams are finished but need to be touched up to be readable

## Packages:
### ClientCommunication
#### Input:
* LoginData from ClientGUI
* CreateData from ClientGUI
* PlaceData from ClientGUI
* GameData from ClientGUI
#### Output: 
* LoginData to ServerCommunication
* CreateData to ServerCommunication
* PlaceData to ServerCommunication
* GameData to ServerCommunication
### ClientGUI
#### Input:
* User input in StartPanel
* User input in LoginPanel
* User input in CreatePanel
* User input in LobbyPanel (multiple types with selecting user to challenge or logout)
* User input in PlacingPanel
* User input in GamePanel
* Server input from response from other user (Lobby challenge response, Placing ship placement, Game opponent moves, Lobby display W/L ratio and active players)
#### Output: 
* LoginData to ClientCommunication
* CreateData to ClientCommunication
* PlaceData to ClientCommunication
* GameData to ClientCommunication
### ServerCommunication
#### Input:
* LoginData from ClientCommunication
* CreateData from ClientCommunication
* PlaceData from ClientCommunication
* GameData from ClientCommunication
#### Output:
* LoginData to ClientCommunication
* CreateData to ClientCommunication
* PlaceData to ClientCommunication
* GameData to ClientCommunication

## Classes:
### StartControl
* Methods:
* Variables:
### StartPanel
* Methods:
* Variables:

### LoginControl
* Methods:
* Variables:
### LoginPanel
* Methods:
* Variables:
### LoginData
* Methods:
* Variables:

### CreateControl
* Methods:
* Variables:
### CreatePanel
* Methods:
* Variables:
### CreateData
* Methods:
* Variables:

### LobbyControl
* Methods:
* Variables:
### LobbyPanel
* Methods:
* Variables:
### LobbyData
* Methods:
* Variables:

### PlacingControl
* Methods:
* Variables:
### PlacingPanel
* Methods:
* Variables:
### PlacingData
* Methods:
* Variables:

### GameControl
* Methods:
* Variables:
### GamePanel
* Methods:
* Variables:
### GameData
* Methods:
* Variables:

### GameClient
* Methods:
* Variables:
### GameServer
* Methods:
* Variables:
### User
* Methods:
* Variables:
### DatabaseFile
* Methods:
* Variables:
### Pieces
* Methods:
* Variables:

