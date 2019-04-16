#import "React/RCTBridgeModule.h"

@interface RCT_EXTERN_MODULE(YandexAppmetrica, NSObject)
  RCT_EXTERN_METHOD(activateWithApiKey:(NSString *)apiKey)
  RCT_EXTERN_METHOD(activateWithConfig:(NSDictionary *)config)
  RCT_EXTERN_METHOD(reportEvent:(NSString *)message)
  RCT_EXTERN_METHOD(reportEventWithParams:(NSString *)message parameters:(nullable NSDictionary *)parameters)
  RCT_EXTERN_METHOD(reportError:(NSString *)message)
  RCT_EXTERN_METHOD(setUserProfileId:(NSString *)userProfileId)
@end
