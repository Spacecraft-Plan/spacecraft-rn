#ifdef RCT_NEW_ARCH_ENABLED
#import "FlightbaseView.h"

#import <react/renderer/components/RNFlightbaseViewSpec/ComponentDescriptors.h>
#import <react/renderer/components/RNFlightbaseViewSpec/EventEmitters.h>
#import <react/renderer/components/RNFlightbaseViewSpec/Props.h>
#import <react/renderer/components/RNFlightbaseViewSpec/RCTComponentViewHelpers.h>

#import "RCTFabricComponentsPlugins.h"
#import "Utils.h"

using namespace facebook::react;

@interface FlightbaseView () <RCTFlightbaseViewViewProtocol>

@end

@implementation FlightbaseView {
    UIView * _view;
}

+ (ComponentDescriptorProvider)componentDescriptorProvider
{
    return concreteComponentDescriptorProvider<FlightbaseViewComponentDescriptor>();
}

- (instancetype)initWithFrame:(CGRect)frame
{
  if (self = [super initWithFrame:frame]) {
    static const auto defaultProps = std::make_shared<const FlightbaseViewProps>();
    _props = defaultProps;

    _view = [[UIView alloc] init];

    self.contentView = _view;
  }

  return self;
}

- (void)updateProps:(Props::Shared const &)props oldProps:(Props::Shared const &)oldProps
{
    const auto &oldViewProps = *std::static_pointer_cast<FlightbaseViewProps const>(_props);
    const auto &newViewProps = *std::static_pointer_cast<FlightbaseViewProps const>(props);

    if (oldViewProps.color != newViewProps.color) {
        NSString * colorToConvert = [[NSString alloc] initWithUTF8String: newViewProps.color.c_str()];
        [_view setBackgroundColor: [Utils hexStringToColor:colorToConvert]];
    }

    [super updateProps:props oldProps:oldProps];
}

Class<RCTComponentViewProtocol> FlightbaseViewCls(void)
{
    return FlightbaseView.class;
}

@end
#endif
