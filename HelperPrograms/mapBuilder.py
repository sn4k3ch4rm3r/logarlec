from xml.dom import minidom 
import os 


class Room:
	def __init__(self, x, y, width, height):
		self.x = x
		self.y = y
		self.width = width
		self.height = height
	
	def getWalls(self):
		walls = []
		for i in range(self.x, self.x + self.width):
			for j in range(self.y, self.y + self.height):
				if i == self.x or i == self.x + self.width-1 or j == self.y or j == self.y + self.height-1:
					walls.append((i,j))
		return walls
	def getFloor(self):
		floor = []
		for i in range(self.x, self.x + self.width):
			for j in range(self.y, self.y + self.height):
				if i != self.x and i != self.x + self.width-1 and j != self.y and j != self.y + self.height-1:
					floor.append((i,j))
		return floor
	

rooms = []

rooms.append(Room(0,0, 23, 10))
rooms.append(Room(0, 11, 18, 7)) #middle room

rooms.append(Room(7, 17, 11, 7))
rooms.append(Room(18, 10, 5, 13)) #right side room
rooms.append(Room(0, 17, 7, 7)) #upper left room


'''
for i in range(23):
	for j in range(24):
		for room in rooms:
			if (i,j) in room.getWalls():
				print("W", end="")
				break
			elif (i,j) in room.getFloor():
				print("F", end="")
				break
		#print(" ", end="")

	print("")
'''


root = minidom.Document() 

map = root.createElement('map') 
root.appendChild(map) 

doors = root.createElement('doors')
map.appendChild(doors)

door = root.createElement('door')
doors.appendChild(door)

currentId = 0
for room in rooms:
	roomElement = root.createElement('room')
	roomElement.setAttribute('id', str(currentId))
	currentId = currentId + 1
	map.appendChild(roomElement)
	for wall in room.getWalls():
		wallElement = root.createElement('tile')
		wallElement.setAttribute('x', str(wall[0]))
		wallElement.setAttribute('y', str(wall[1]))
		wallElement.setAttribute('type', 'wall')
		roomElement.appendChild(wallElement)
	for floor in room.getFloor():
		floorElement = root.createElement('tile')
		floorElement.setAttribute('x', str(floor[0]))
		floorElement.setAttribute('y', str(floor[1]))
		floorElement.setAttribute('type', 'floor')
		roomElement.appendChild(floorElement)

xml_str = root.toprettyxml(indent ="\t") 

currentDir = os.path.dirname(os.path.realpath(__file__))
save_path_file = os.path.join(currentDir, "pyMapOut.xml")

with open(save_path_file, "w") as f: 
	f.write(xml_str) 
