// This guard prevent this file to be compiled in the old architecture.
#ifdef RCT_NEW_ARCH_ENABLED
#import <React/RCTViewComponentView.h>
#import <UIKit/UIKit.h>

#ifndef MycmViewNativeComponent_h
#define MycmViewNativeComponent_h

NS_ASSUME_NONNULL_BEGIN

@interface MycmView : RCTViewComponentView
@end

NS_ASSUME_NONNULL_END

#endif /* MycmViewNativeComponent_h */
#endif /* RCT_NEW_ARCH_ENABLED */
