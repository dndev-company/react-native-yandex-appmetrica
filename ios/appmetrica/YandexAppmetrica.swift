import Foundation
import YandexMobileMetrica

@objc(YandexAppmetrica)
class YandexAppmetrica: NSObject {
  @objc
  func activateWithApiKey(_ apiKey: String) {
    print("ActivateWithApiKey")
    let configurator = YMMYandexMetricaConfiguration.init(apiKey: apiKey)
    
    YMMYandexMetrica.activate(with: configurator!)
  }
  
  @objc
  func activateWithConfig(_ config: [AnyHashable : Any]?) {
    print("ActivateWithConfig")
    let configurator = YMMYandexMetricaConfiguration.init(apiKey: config?["apiKey"] as! String)
    
    if (config?["sessionTimeout"] != nil) {
      configurator?.sessionTimeout = UInt(config?["sessionTimeout"] as! UInt)
    }
    
    if (config?["firstActivationAsUpdate"] != nil) {
      configurator?.handleFirstActivationAsUpdate = config?["firstActivationAsUpdate"] as! Bool
    }
    
    YMMYandexMetrica.activate(with: configurator!)
  }
  
  @objc
  func reportEvent(_ message: String?) {
    print("ReportEvent")
    YMMYandexMetrica.reportEvent(message!)
  }
  
  @objc
  func reportEventWithParams(_ message: String?, parameters: [AnyHashable : Any]?) {
    print("ReportEvent2")
    YMMYandexMetrica.reportEvent(message!, parameters: parameters)
  }
  
  @objc
  func reportError(_ message: String) {
    print("ReportError")
    let exception = NSException(name: NSExceptionName(rawValue: message), reason: nil, userInfo: nil)
    YMMYandexMetrica.reportError(message, exception: exception, onFailure: nil)
  }
  
  @objc
  func setUserProfileId(_ userProfileId: String) {
    YMMYandexMetrica.setUserProfileID(userProfileId)
  }
}
