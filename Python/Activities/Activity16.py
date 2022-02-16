class car:
    def __init__(self, manufacturer, model, make, transmission, color):
        self.manufacturer = manufacturer
        self.model = model
        self.make = make
        self.transmission = transmission
        self.color = color

    def accelerate(self):
        print(self.manufacturer + " " + self.model + " " + "is moving")

    def stop(self):
        print(self.manufacturer + " " + self.model + " " + "has stopped")


car1 = car("Toyota", "x", "2010", "manual", "black")
car2 = car("Hyundai", "x", "2010", "manual", "black")
car3 = car("Tata", "x", "2010", "manual", "black")

car1.accelerate()
car1.stop()
car2.accelerate()
car2.stop()
car3.accelerate()
car3.stop()
