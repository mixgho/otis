//
//  LoginVC.swift
//  otis
//
//  Created by mixgho on 11/6/16.
//  Copyright © 2016 Enrian Partners. All rights reserved.
//

import UIKit

class LoginVC: UIViewController {

    @IBOutlet weak var passwordLabel: UILabel!
    @IBOutlet weak var passwordTextField: UITextField!
    @IBOutlet weak var loginButton: UIButton!
    
    override func viewDidAppear(_ animated: Bool) {
        passwordTextField.text = ""
    }

    @IBAction func login(_ sender: UIButton) {
        // TODO: check pass on server
        let pass = passwordTextField.text
        
        if pass == nil || pass == "" {
            return
        }
        
        let uri = "http://192.168.2.2:8080/otis/user?password=" + pass!
        print(uri	)
        
        let url = URL(string: uri)
        
        let task = URLSession.shared.dataTask(with: url!) { data, response, error in
            guard error == nil else {
                print(error!)
                return
            }
            guard data != nil && data!.count > 0 else {
                print("No data")
                return
            }
            
            let json = try! JSONSerialization.jsonObject(with: data!, options: []) as! NSDictionary
            
            let user = User()
            user.id = json.object(forKey: "id") as! Int?
            user.name = json.object(forKey: "name") as! String?
            
            UserDefaults.standard.set(user.name, forKey: "user")
            
            // let tabVC = UIStoryboard(name: "Main", bundle: nil).instantiateViewController(withIdentifier: "tabBarController") as! UITabBarController
            // UIApplication.shared.keyWindow?.rootViewController = tabVC
            self.dismiss(animated: true, completion: nil)
	}
        
        task.resume()
    }
}
