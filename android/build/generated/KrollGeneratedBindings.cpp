/* C++ code produced by gperf version 3.0.4 */
/* Command-line: gperf -L C++ -E -t /tmp/miga/tisms-generated/KrollGeneratedBindings.gperf  */
/* Computed positions: -k'' */

#line 3 "/tmp/miga/tisms-generated/KrollGeneratedBindings.gperf"


#include <string.h>
#include <v8.h>
#include <KrollBindings.h>

#include "ti.miga.sms.receive.TismsModule.h"


#line 13 "/tmp/miga/tisms-generated/KrollGeneratedBindings.gperf"
struct titanium::bindings::BindEntry;
/* maximum key range = 1, duplicates = 0 */

class TismsBindings
{
private:
  static inline unsigned int hash (const char *str, unsigned int len);
public:
  static struct titanium::bindings::BindEntry *lookupGeneratedInit (const char *str, unsigned int len);
};

inline /*ARGSUSED*/
unsigned int
TismsBindings::hash (register const char *str, register unsigned int len)
{
  return 0;
}

struct titanium::bindings::BindEntry *
TismsBindings::lookupGeneratedInit (register const char *str, register unsigned int len)
{
  enum
    {
      TOTAL_KEYWORDS = 1,
      MIN_WORD_LENGTH = 31,
      MAX_WORD_LENGTH = 31,
      MIN_HASH_VALUE = 0,
      MAX_HASH_VALUE = 0
    };

  static struct titanium::bindings::BindEntry wordlist[] =
    {
#line 15 "/tmp/miga/tisms-generated/KrollGeneratedBindings.gperf"
      {"ti.miga.sms.receive.TismsModule", ::ti::miga::sms::receive::TismsModule::bindProxy, ::ti::miga::sms::receive::TismsModule::dispose}
    };

  if (len <= MAX_WORD_LENGTH && len >= MIN_WORD_LENGTH)
    {
      register int key = hash (str, len);

      if (key <= MAX_HASH_VALUE && key >= 0)
        {
          register const char *s = wordlist[key].name;

          if (*str == *s && !strcmp (str + 1, s + 1))
            return &wordlist[key];
        }
    }
  return 0;
}
#line 16 "/tmp/miga/tisms-generated/KrollGeneratedBindings.gperf"

