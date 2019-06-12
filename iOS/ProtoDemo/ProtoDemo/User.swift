//
//  File.swift
//  ProtoDemo
//
//  Created by Kelvin Chan on 2019-06-06.
//  Copyright © 2019 NuData. All rights reserved.
//

import Foundation

class User {
    static func generatePerson() -> Person {
        var person = Person()
        person.name = "Kelvin"
        person.email = "chan-kelv@github.com"
        
        var phoneNumber = Person.PhoneNumber.init()
        phoneNumber.number = "800-555-1111"
        phoneNumber.type = Person.PhoneType.mobile
        
        person.phones.append(phoneNumber)
        
        return person
    }
    
    static func serializePerson() -> Data? {
        var person = Person()
        person.name = "Kyle Broflovski"
        person.email = "kyle.broflovski@southpark.com"
        
        var phoneNumber = Person.PhoneNumber.init()
        phoneNumber.number = "800-555-2222"
        phoneNumber.type = Person.PhoneType.mobile
        
        person.phones.append(phoneNumber)
        
        return try? person.serializedData()
    }
    
    static func deserializePerson(personByteArray: Data) -> Person? {
        return try? Person(serializedData: personByteArray)
    }
    
    static func generateByte(person:Person) -> Data? {
        let data = try? person.serializedData()
        return data
    }
}
