//
//  ViewController.swift
//  ProtoDemo
//
//  Created by Kelvin Chan on 2019-06-06.
//  Copyright © 2019 NuData. All rights reserved.
//

import UIKit

class ViewController: UIViewController {

    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view, typically from a nib.
    }

    @IBAction func proto_tapped(_ sender: Any) {
        let user = User.generatePerson()
        if let data = User.generateByte(person: user) {
            print(String(bytes: data, encoding: String.Encoding.utf8) ?? "")
        }
    }
}
