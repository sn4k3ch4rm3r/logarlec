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


'''
root = minidom.Document() 

map = root.createElement('map') 
root.appendChild(map) 

doors = root.createElement('doors')
map.appendChild(doors)

for i in range(23):
	for i in range(24):
		None

room = root.createElement('room')

map.appendChild(room)

door = root.createElement('door')
doors.appendChild(door)

xml_str = root.toprettyxml(indent ="\t") 

save_path_file = "gfg.xml"

with open(save_path_file, "w") as f: 
	f.write(xml_str) 

'''