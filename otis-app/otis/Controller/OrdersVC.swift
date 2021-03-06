import UIKit

class OrdersVC: UITableViewController {
    
    
    override func viewDidAppear(_ animated: Bool) {
        self.pingLabel.text = "Loading..."
        
        let url = URL(string: "http://192.168.2.2:8080/otis/")
        let task = URLSession.shared.dataTask(with: url!) { data, response, error in
            guard error == nil else {
                self.pingLabel.text = error?.localizedDescription
                print(error!)
                return
            }
            guard data != nil else {
                self.pingLabel.text = "No data"
                print("No data")
                return
            }
            
            // let json = try! JSONSerialization.jsonObject(with: data!, options: []) as! String
            let result = String(data: data!, encoding: String.Encoding.utf8)!
            DispatchQueue.main.async() {
                self.pingLabel.text = result
            }
            print(result)
        }
        
        task.resume()
    }
}

