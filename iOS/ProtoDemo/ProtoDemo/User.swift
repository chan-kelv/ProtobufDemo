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
    
    static func generateByte(person:Person) -> Data? {
        let data = try? person.serializedData()
        return data
    }
}
